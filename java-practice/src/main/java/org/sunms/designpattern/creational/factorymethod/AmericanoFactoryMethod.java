package org.sunms.designpattern.creational.factorymethod;

/**
 * 실제로 만들어지는 커피 ① 아메리카노입니다.
 *
 * <p><b>역할:</b> Concrete Product (구체적인 제품)</p>
 *
 * @see CoffeeFactoryMethod
 * @see AmericanoMachineFactoryMethod
 */
public class AmericanoFactoryMethod implements CoffeeFactoryMethod {

    /**
     * {@inheritDoc}
     *
     * @return "아메리카노"
     */
    @Override
    public String getName() {
        return "아메리카노";
    }

    /**
     * 에스프레소 샷에 뜨거운 물을 부어 아메리카노를 만듭니다.
     */
    @Override
    public void brew() {
        System.out.println("  에스프레소 샷 + 뜨거운 물 → 아메리카노 완성");
    }
}
