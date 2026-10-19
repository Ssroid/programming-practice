package org.sunms.designpattern.behavioral.strategy;

/**
 * 간편결제(카카오페이) 전략입니다.
 *
 * <p><b>역할:</b> Concrete Strategy (구체적인 전략 ②)</p>
 */
public class KakaoPayStrategy implements PaymentStrategy {

    /** 결제 요청을 받을 휴대폰 번호 */
    private final String phoneNumber;

    /**
     * 카카오페이 결제 전략을 만듭니다.
     *
     * @param phoneNumber 휴대폰 번호
     */
    public KakaoPayStrategy(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 휴대폰으로 결제 요청을 보내 결제합니다.
     *
     * @param amount 결제할 금액 (원)
     */
    @Override
    public void pay(int amount) {
        System.out.println("  [카카오페이] " + phoneNumber + " 으로 결제 요청 → " + amount + "원 결제 완료");
    }
}
