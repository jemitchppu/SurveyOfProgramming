import psycopg2
import json

## Connect to database
conn = psycopg2.connect("dbname=postgres user=postgres password=Kadpmu08")

##Open the connection
current = conn.cursor()

## Read the JSON FILE
with open('input.json', 'r') as file:
    data = json.load(file)

## Iterate through JSON
for item in data:
    current.execute("INSERT INTO n64games (title, genre, year, developer, publisher, director, platform, price, switch) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s)",
    (item['title'], item['genre'], item['year'], item['developer'], item['publisher'], item['director'], item['platform'], item['price'], item['switch']))

# Commit changes
conn.commit()
# Close Connection
current.close()
conn.close()