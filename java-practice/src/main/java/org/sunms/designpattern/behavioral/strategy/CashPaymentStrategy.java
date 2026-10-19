package org.sunms.designpattern.behavioral.strategy;

/**
 * 현금 결제 전략입니다. 거스름돈을 계산합니다.
 *
 * <p><b>역할:</b> Concrete Strategy (구체적인 전략 ③)</p>
 */
public class CashPaymentStrategy implements PaymentStrategy {

    /** 손님이 낸 현금 */
    private final int paidCash;

    /**
     * 현금 결제 전략을 만듭니다.
     *
     * @param paidCash 손님이 낸 현금 (원)
     */
    public CashPaymentStrategy(int paidCash) {
        this.paidCash = paidCash;
    }

    /**
     * 현금으로 결제하고 거스름돈을 계산합니다. 금액이 부족하면 결제하지 않습니다.
     *
     * @param amount 결제할 금액 (원)
     */
    @Override
    public void pay(int amount) {
        if (paidCash < amount) {
            System.out.println("  [현금 결제] 금액이 부족합니다! (" + (amount - paidCash) + "원 부족)");
            return;
        }
        System.out.println("  [현금 결제] " + paidCash + "원 받음 → 거스름돈 " + (paidCash - amount) + "원");
    }
}
