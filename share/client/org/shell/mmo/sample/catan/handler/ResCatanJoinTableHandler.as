package org.shell.mmo.sample.catan.handler;

import org.shell.mmo.sample.message.proto.LogicClient;
import org.shell.mmo.sample.message.proto.Global.Module;

public class ResCatanJoinTableHandler extends org.shell.mmo.sample.message.CatanMessageHandler<LogicClient.ResCatanJoinTable> {
    @Override
    protected void execute(LogicClient.ResCatanJoinTable message) {
        // TODO
    }

    @Override
    public Module module() {
        return Module.CATAN;
    }
}