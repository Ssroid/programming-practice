package org.sunms.designpattern.creational.abstractfactory;

/**
 * "의자라면 앉을 수 있어야 한다({@link #sitOn()})"는 공통 규격입니다.
 *
 * <p><b>역할:</b> Abstract Product (추상 제품 ①: 의자의 규격)<br>
 * ※ 이름에 AbstractFactory가 붙어 있지만 "공장"이 아니라 공장이 만드는 "제품"입니다.</p>
 *
 * <h2>왜 인터페이스가 필요한가?</h2>
 * <p>공장 규격({@link FurnitureAbstractFactory})의 {@code createChair()} 반환 타입으로 쓰이기 위해서입니다.
 * 모던 공장은 모던 의자를, 클래식 공장은 클래식 의자를 돌려주지만
 * 받는 쪽에서는 둘 다 "의자({@code ChairAbstractFactory})"로 똑같이 다룰 수 있습니다.</p>
 *
 * <h2>왜 추상화가 필요한가? (인터페이스가 없다면?)</h2>
 * <p>{@code createChair()}의 반환 타입을 {@code ModernChair}로 정하면 클래식 공장은 클래식 의자를 돌려줄 수 없습니다.<br>
 * → 공장 규격 자체를 만들 수 없게 되므로, 제품도 반드시 추상화되어 있어야 합니다.</p>
 *
 * @see ModernChairAbstractFactory
 * @see ClassicChairAbstractFactory
 */
public interface ChairAbstractFactory {

    /**
     * 의자에 앉습니다.
     */
    void sitOn();
}
