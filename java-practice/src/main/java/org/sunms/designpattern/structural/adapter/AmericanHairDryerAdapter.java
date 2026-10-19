package org.sunms.designpattern.structural.adapter;

/**
 * 미국산 헤어드라이어입니다. 110V 전용이고 메서드 이름도 다릅니다.
 *
 * <p><b>역할:</b> Adaptee (적응 대상, 규격이 안 맞는 기존 클래스)</p>
 *
 * <ul>
 *   <li>{@link Plug220vAdapter}를 구현하지 않음 → 한국 콘센트에 직접 꽂을 수 없음</li>
 *   <li>외부 라이브러리라고 가정 → 이 코드는 "수정할 수 없다"고 생각하세요!</li>
 * </ul>
 *
 * @see PlugConverterAdapter
 */
public class AmericanHairDryerAdapter {

    /**
     * 110V 전기로 작동합니다.
     */
    public void connect110v() {
        System.out.println("  [미국 드라이어] 110V 전기로 작동! 위이잉~ 머리를 말립니다.");
    }
}
