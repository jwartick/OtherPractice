/*
Suppose we could access yesterday's stock prices as a list, where:

The indices are the time in minutes past trade opening time, which was 9:30am local time.
The values are the price in dollars of Apple stock at that time.
So if the stock cost $500 at 10:30am, stock_prices_yesterday[60] = 500.

Write an efficient function that takes stock_prices_yesterday and returns the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.

notes:
(aka buying one and then selling it that same day for a higher price)
- window is from 9:30am to 4pm (16:00) > 6.5 hours = 6*60 + 30=390

planning
--------
int[390] stock_prices_yesterday
(initialize with random numbers >> highest stock during bull ~$1000 << lowest ~$150
>>for single day



 */
public class StockTrade
{
    public static void main(String[] args)
    {

    }
}
