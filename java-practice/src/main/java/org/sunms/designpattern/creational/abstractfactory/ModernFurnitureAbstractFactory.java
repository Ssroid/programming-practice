package org.sunms.designpattern.creational.abstractfactory;

/**
 * "모던 스타일 공장"입니다. 여기서 나오는 가구는 무조건 모던 스타일!
 *
 * <p><b>역할:</b> Concrete Factory (구체적인 공장)</p>
 *
 * @see ModernChairAbstractFactory
 * @see ModernSofaAbstractFactory
 */
public class ModernFurnitureAbstractFactory implements FurnitureAbstractFactory {

    /**
     * 모던 의자를 만듭니다.
     *
     * @return 새 {@link ModernChairAbstractFactory} 객체
     */
    @Override
    public ChairAbstractFactory createChair() {
        return new ModernChairAbstractFactory();
    }

    /**
     * 모던 소파를 만듭니다.
     *
     * @return 새 {@link ModernSofaAbstractFactory} 객체
     */
    @Override
    public SofaAbstractFactory createSofa() {
        return new ModernSofaAbstractFactory();
    }
}
