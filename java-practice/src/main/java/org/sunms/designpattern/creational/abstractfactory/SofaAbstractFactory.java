package org.sunms.designpattern.creational.abstractfactory;

/**
 * "소파라면 누울 수 있어야 한다({@link #lieOn()})"는 공통 규격입니다.
 *
 * <p><b>역할:</b> Abstract Product (추상 제품 ②: 소파의 규격)<br>
 * ※ 이름에 AbstractFactory가 붙어 있지만 "공장"이 아니라 공장이 만드는 "제품"입니다.</p>
 *
 * <h2>왜 인터페이스가 필요한가?</h2>
 * <p>{@link ChairAbstractFactory}와 같은 이유입니다.
 * 공장마다 다른 소파를 돌려주더라도, 받는 쪽은 "소파"라는 공통 타입으로 다룰 수 있어야 합니다.</p>
 *
 * <h2>왜 추상화가 필요한가?</h2>
 * <p>의자와 소파가 각각 추상화되어 있어야 "모던 세트", "클래식 세트"처럼
 * 제품 묶음을 공장 단위로 통째로 바꿔 끼울 수 있습니다.</p>
 *
 * @see ModernSofaAbstractFactory
 * @see ClassicSofaAbstractFactory
 */
public interface SofaAbstractFactory {

    /**
     * 소파에 눕습니다.
     */
    void lieOn();
}
