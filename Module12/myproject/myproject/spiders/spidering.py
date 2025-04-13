import scrapy

class Spiderman(scrapy.Spider):
    name = 'Spiderman'
    start_urls = ['https://n64games.netlify.app']

    ##parse the extraction that is received from the request
    def parse(self, response):
        for game in response.css('div.game'):
            yield {
                'title': game.css('h2::text').get(),
                'genre': game.css('p:nth-of-type(1) span::text').get(),
                'year': game.css('p:nth-of-type(2) span::text').get(),
                'developer': game.css('p:nth-of-type(3) span::text').get(),
                'publisher': game.css('p:nth-of-type(4) span::text').get(),
                'director': game.css('p:nth-of-type(5) span::text').get(),
                'platform': game.css('p:nth-of-type(6) span::text').get(),
                'price': game.css('p:nth-of-type(7) span::text').get(),
                'switch': game.css('p:nth-of-type(8) span::text').get(),
            }
