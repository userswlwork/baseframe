package com.mobile.base.openapi;

/**
 * User: 孙伟力
 * Date: 15/8/29
 * Time: 下午12:18
 */
public abstract class CommandFactory {
    public abstract BaseCommand getCommand(IBaseRequest baseRequest);
}
