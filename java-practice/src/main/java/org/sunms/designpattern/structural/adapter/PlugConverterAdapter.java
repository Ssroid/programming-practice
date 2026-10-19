package org.sunms.designpattern.structural.adapter;

/**
 * 220V 콘센트와 110V 드라이어를 연결해 주는 변환기(돼지코)입니다.
 *
 * <p><b>역할:</b> Adapter (변환기)</p>
 *
 * <h2>핵심 구조</h2>
 * <ol>
 *   <li>{@code implements Plug220vAdapter} → 겉모습은 220V 플러그 (한국 콘센트에 꽂을 수 있음)</li>
 *   <li>필드로 {@link AmericanHairDryerAdapter}를 보관 → 안쪽에서는 미국 드라이어를 붙잡고 있음</li>
 *   <li>{@link #supply220v()}가 호출되면 → 변환 후 {@code dryer.connect110v()}를 대신 호출</li>
 * </ol>
 * <p>이렇게 "다른 객체를 필드로 품어서 사용하는 방식"을 객체 어댑터(Object Adapter)라고 합니다.</p>
 *
 * @see Plug220vAdapter
 * @see AmericanHairDryerAdapter
 */
public class PlugConverterAdapter implements Plug220vAdapter {

    /** 감싸고 있는 대상 (Adaptee) */
    private final AmericanHairDryerAdapter dryer;

    /**
     * 미국 드라이어를 감싸는 변환기를 만듭니다.
     *
     * @param dryer 연결할 미국 드라이어
     */
    public PlugConverterAdapter(AmericanHairDryerAdapter dryer) {
        this.dryer = dryer;
    }

    /**
     * 220V를 110V로 변환한 뒤, 드라이어에게 호출을 "번역"해서 전달합니다.
     */
    @Override
    public void supply220v() {
        System.out.println("  [돼지코 변환기] 220V → 110V 로 전압 변환 중...");
        dryer.connect110v();   // ★ 호출을 Adaptee 의 메서드로 "번역"해서 전달
    }
}
