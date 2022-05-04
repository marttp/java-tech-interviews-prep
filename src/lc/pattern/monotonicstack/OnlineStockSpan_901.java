package lc.pattern.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineStockSpan_901 {

  private static class StockSpanner {

    Deque<Stock> stack;

    public StockSpanner() {
      this.stack = new ArrayDeque<>();
    }

    public int next(int price) {
      int span = 1;
      while (!this.stack.isEmpty() && this.stack.peekFirst().price <= price) {
        span += stack.removeFirst().span;
      }
      // If we push new one, so that's mean we already sum of the span into this price
      this.stack.addFirst(new Stock(price, span));
      return span;
    }
  }

  private static class Stock {

    int price;
    int span;

    public Stock(int price, int span) {
      this.price = price;
      this.span = span;
    }
  }
}
