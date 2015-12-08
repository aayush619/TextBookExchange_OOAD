package com.example.ali.loginregister;

import java.io.Serializable;

/**
 * Created by zhangshuzhe on 12/7/15.
 */
public abstract class schoolRalatedItem implements Serializable {
    public schoolRalatedItem(){}

    public abstract void post();
    public abstract void delete();
}
