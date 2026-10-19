package org.sunms.designpattern.structural.composite;

/**
 * 파일입니다. 안에 다른 것을 담을 수 없는 "하나짜리"입니다.
 *
 * <p><b>역할:</b> Leaf (잎, 끝 노드)</p>
 *
 * @see FolderComposite
 */
public class FileComposite implements FileSystemItemComposite {

    /** 파일 이름 */
    private final String name;
    /** 파일 크기 (KB) */
    private final int size;

    /**
     * 파일을 만듭니다.
     *
     * @param name 파일 이름
     * @param size 파일 크기 (KB)
     */
    public FileComposite(String name, int size) {
        this.name = name;
        this.size = size;
    }

    /**
     * {@inheritDoc}
     *
     * @return 파일 이름
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * 파일은 자기 크기만 반환하면 끝입니다.
     *
     * @return 파일 크기 (KB)
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * {@inheritDoc}
     *
     * @param indent 앞에 붙일 들여쓰기 문자열
     */
    @Override
    public void print(String indent) {
        System.out.println(indent + "[파일] " + name + " (" + size + "KB)");
    }
}
