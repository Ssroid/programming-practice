package org.sunms.designpattern.creational.abstractfactory;

/**
 * 모던 스타일 세트의 "의자"입니다.
 *
 * <p><b>역할:</b> Concrete Product (구체적인 제품)</p>
 *
 * @see ModernFurnitureAbstractFactory
 */
public class ModernChairAbstractFactory implements ChairAbstractFactory {

    /**
     * 매끈한 금속 다리의 심플한 의자에 앉습니다.
     */
    @Override
    public void sitOn() {
        System.out.println("  [모던 의자] 매끈한 금속 다리의 심플한 의자에 앉았습니다.");
    }
}
