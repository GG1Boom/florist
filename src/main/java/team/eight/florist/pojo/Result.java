package team.eight.florist.pojo;

import java.util.List;

//专门封装返回的数据信息（此时封装原则来自LayUI table的接口需求）
public class Result {


    //code默认成功的情况为code=0
    private Integer code;
    private String msg;
    private Long count; //数据总量
    private List data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
