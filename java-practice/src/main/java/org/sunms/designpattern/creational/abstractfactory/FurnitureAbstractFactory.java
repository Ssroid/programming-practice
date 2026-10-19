package org.sunms.designpattern.creational.abstractfactory;

/**
 * "가구 공장이라면 의자와 소파를 만들 수 있어야 한다"는 약속(목록)입니다.
 *
 * <p><b>역할:</b> Abstract Factory (추상 공장, "공장의 규격")<br>
 * 패턴 전체 설명은 {@link MainAbstractFactory#main(String[])}의 주석을 참고하세요.</p>
 *
 * <h2>이 인터페이스는 무엇인가?</h2>
 * <p>모던 공장, 클래식 공장 모두 이 약속을 지킵니다.</p>
 *
 * <h2>왜 인터페이스가 필요한가?</h2>
 * <p>가구를 사용하는 쪽({@code decorateLivingRoom})이 "어떤 공장인지 모른 채" 가구를 받을 수 있게 하기 위해서입니다.</p>
 * <pre>{@code
 * static void decorateLivingRoom(FurnitureAbstractFactory factory) {
 *     factory.createChair();   // 모던 공장이면 모던 의자, 클래식 공장이면 클래식 의자
 *     factory.createSofa();    // 같은 공장이므로 소파도 반드시 같은 스타일!
 * }
 * }</pre>
 * <ul>
 *   <li>매개변수 타입이 인터페이스라서 어떤 공장이든 받을 수 있고,</li>
 *   <li>"공장 하나 = 스타일 하나"이므로 세트가 섞일 수 없습니다.</li>
 * </ul>
 *
 * <h2>왜 추상화가 필요한가? (인터페이스가 없다면?)</h2>
 * <p>{@code decorateLivingRoom(ModernFurnitureAbstractFactory factory)}처럼 구체 공장을 받아야 해서
 * 클래식 거실용 메서드를 또 만들어야 합니다. 스타일이 늘어날 때마다 메서드도 늘어나죠.<br>
 * → 인터페이스로 추상화하면, 테마 전환이 "공장 객체 교체 한 줄"로 끝납니다.</p>
 *
 * @see ModernFurnitureAbstractFactory
 * @see ClassicFurnitureAbstractFactory
 */
public interface FurnitureAbstractFactory {

    /**
     * 이 공장 스타일의 의자를 만듭니다.
     *
     * @return 공장 스타일에 맞는 의자
     */
    ChairAbstractFactory createChair();

    /**
     * 이 공장 스타일의 소파를 만듭니다.
     *
     * @return 공장 스타일에 맞는 소파
     */
    SofaAbstractFactory createSofa();
}
