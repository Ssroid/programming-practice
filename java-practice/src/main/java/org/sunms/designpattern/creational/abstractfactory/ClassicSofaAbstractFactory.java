package org.sunms.designpattern.creational.abstractfactory;

/**
 * 클래식 스타일 세트의 "소파"입니다.
 *
 * <p><b>역할:</b> Concrete Product (구체적인 제품)</p>
 *
 * @see ClassicFurnitureAbstractFactory
 */
public class ClassicSofaAbstractFactory implements SofaAbstractFactory {

    /**
     * 벨벳 천의 고풍스러운 소파에 눕습니다.
     */
    @Override
    public void lieOn() {
        System.out.println("  [클래식 소파] 벨벳 천의 고풍스러운 소파에 누웠습니다.");
    }
}
