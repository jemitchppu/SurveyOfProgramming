import requests
from bs4 import BeautifulSoup
import json

def scrape_indeed_jobs(job_title, location, num_pages):
    base_url = f"https://www.indeed.com/jobs?q={job_title.replace(' ', '+')}&l={location.replace(' ', '+').replace(',', '%2C')}"
    jobs = []

    for page in range(num_pages):
        url = f"{base_url}&start={page * 10}"
        response = requests.get(url)

        #create html page with scraped contents to see why i am pulling 0 jobs
        with open(f"page_{page+1}.html", "w", encoding="utf-8") as f:
            f.write(response.text)

        soup = BeautifulSoup(response.text, 'html.parser')
        job_listings = soup.find_all(class_='jobsearch-SerpJobCard')
        print(f"Page {page+1}: Found {len(job_listings)} job listings.")

        for job in job_listings:
            title = job.find(class_='title').text.strip()
            company = job.find(class_='company').text.strip()
            location = job.find(class_='location').text.strip()
            summary = job.find(class_='summary').text.strip()
            salary = job.find(class_='salaryText')
            salary = salary.text.strip() if salary else None

            jobs.append({
                'Title': title,
                'Company': company,
                'Location': location,
                'Summary': summary,
                'Salary': salary
            })

    return jobs
    
def save_to_json(jobs, filename):
    with open(filename, 'w') as f:
            json.dump(jobs, f, indent=4)

if __name__ == "__main__":
    job_title = input("Enter job title: ")
    location = input("Enter location: ")
    num_pages = int(input("Enter number of pages: "))

    jobs = scrape_indeed_jobs(job_title, location, num_pages)
    save_to_json(jobs, 'jobs.json')
    print(f"Scraped {len(jobs)} job listings. Saved to jobs.json")