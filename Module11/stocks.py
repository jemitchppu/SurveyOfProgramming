import yfinance as yf
import matplotlib.pyplot as plt
import schedule
import time

def fetch_stock_data(ticker, period='1d', intervale='1m'):
    stock = yf.Ticker(ticker)
    data = stock.history(period=period, interval=intervale)
    return data

def plot_stock_data(data, ticker):
    plt.figure(figsize=(10,6))
    plt.plot(data['Close'], label=f'{ticker} Close Price', color='blue')
    plt.title(f'{ticker} Stock Price')
    plt.xlabel('Date')
    plt.ylabel('Price')
    plt.legend()
    plt.grid(True)
    plt.show()

def monitor_stock(ticker):
    data = fetch_stock_data(ticker)
    plot_stock_data(data, ticker)

def main():
    ticker_symbol = 'GME'

    #Fetch the stock data
    monitor_stock(ticker_symbol)
    schedule.every().hour.do(lambda: monitor_stock(ticker_symbol))

    #need script to continue running
    while True:
        schedule.run_pending()
        time.sleep(1)

if __name__ == "__main__":
    main()

