package org.sunms.designpattern.creational.abstractfactory;

/**
 * "클래식 스타일 공장"입니다. 여기서 나오는 가구는 무조건 클래식 스타일!
 *
 * <p><b>역할:</b> Concrete Factory (구체적인 공장)</p>
 *
 * @see ClassicChairAbstractFactory
 * @see ClassicSofaAbstractFactory
 */
public class ClassicFurnitureAbstractFactory implements FurnitureAbstractFactory {

    /**
     * 클래식 의자를 만듭니다.
     *
     * @return 새 {@link ClassicChairAbstractFactory} 객체
     */
    @Override
    public ChairAbstractFactory createChair() {
        return new ClassicChairAbstractFactory();
    }

    /**
     * 클래식 소파를 만듭니다.
     *
     * @return 새 {@link ClassicSofaAbstractFactory} 객체
     */
    @Override
    public SofaAbstractFactory createSofa() {
        return new ClassicSofaAbstractFactory();
    }
}
