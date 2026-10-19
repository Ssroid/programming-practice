package org.sunms.designpattern.structural.adapter;

/**
 * "한국 콘센트에 꽂으려면 220V 플러그 모양이어야 한다"는 규격입니다.
 *
 * <p><b>역할:</b> Target (클라이언트가 기대하는 규격)<br>
 * 패턴 전체 설명은 {@link MainAdapter#main(String[])}의 주석을 참고하세요.</p>
 *
 * <h2>이 인터페이스는 무엇인가?</h2>
 * <p>콘센트({@link KoreanSocketAdapter})는 오직 이 규격만 알고 있습니다.</p>
 *
 * <h2>왜 인터페이스가 필요한가?</h2>
 * <p>어댑터(변환기)가 "끼어들 자리"를 만들어 주기 때문입니다.</p>
 * <pre>{@code
 * public void plugIn(Plug220vAdapter plug)   // 콘센트는 "규격"만 받음
 * }</pre>
 * <p>이렇게 되어 있으면 한국 선풍기(원래 규격을 따름)든,
 * 돼지코를 낀 미국 드라이어(변환기가 규격을 대신 따름)든 똑같이 꽂을 수 있습니다.</p>
 *
 * <h2>왜 추상화가 필요한가? (인터페이스가 없다면?)</h2>
 * <ul>
 *   <li>콘센트가 {@code plugIn(KoreanFanAdapter fan)}처럼 "구체 클래스"를 받는다면
 *       선풍기 말고는 아무것도 꽂을 수 없고, 변환기를 만들어도 끼울 방법이 없습니다.</li>
 *   <li>→ 기기가 추가될 때마다 콘센트에 {@code plugIn} 메서드를 새로 만들어야 합니다.</li>
 *   <li>→ 클라이언트가 "규격(인터페이스)"에만 의존해야 어댑터 패턴이 성립합니다.</li>
 * </ul>
 *
 * @see KoreanFanAdapter
 * @see PlugConverterAdapter
 * @see KoreanSocketAdapter#plugIn(Plug220vAdapter)
 */
public interface Plug220vAdapter {

    /**
     * 220V 전기를 받아 동작합니다.
     */
    void supply220v();
}
