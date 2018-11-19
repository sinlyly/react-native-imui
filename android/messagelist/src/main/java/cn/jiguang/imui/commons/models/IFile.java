package cn.jiguang.imui.commons.models;


/**
 * 文件属性封装
 * @author  sin
 */
public interface IFile extends IExtend {

    void setId(String id);
    String getId();
    String getSize();
    String getName();
    String getExt();
    String getPath();
}
