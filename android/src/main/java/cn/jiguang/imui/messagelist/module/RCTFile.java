package cn.jiguang.imui.messagelist.module;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import cn.jiguang.imui.commons.models.IFile;
import cn.jiguang.imui.messagelist.MessageConstant;

/**
 *
 * 文件类型消息详细实体
 * @author sin
 */
public class RCTFile extends RCTExtend implements IFile {


    private String id;
    private String name;
    private String ext;
    private String path;
    private String size;


    /**
     * RCTFile构造函数
     * @param name
     * @param ext
     * @param path
     * @param size
     */
    public  RCTFile(String name,String ext,String path,String size){
        this.name = name;
        this.ext = ext;
        this.path = path;
        this.size = size;
    }


    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getSize() {
        return this.size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getExt() {
        return this.ext;
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    JsonElement toJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(MessageConstant.File.NAME, name);
        json.addProperty(MessageConstant.File.PATH, path);
        json.addProperty(MessageConstant.File.SIZE, size);
        json.addProperty(MessageConstant.File.EXT, ext);
        return json;
    }

    @Override
    WritableMap toWritableMap() {
        WritableMap writableMap = Arguments.createMap();
        writableMap.putString(MessageConstant.File.NAME, name);
        writableMap.putString(MessageConstant.File.PATH, path);
        writableMap.putString(MessageConstant.File.SIZE, size);
        writableMap.putString(MessageConstant.File.EXT, ext);
        return writableMap;
    }
}
