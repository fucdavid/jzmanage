/*
 *    Copyright 2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.caches.redis;

import redis.clients.jedis.JedisPoolConfig;

public class ConfigWithHost extends JedisPoolConfig {
	
	private String host;       //服务器地址
	private int port;          //服务器端口
	private String pass;       //服务器密码
	private int timeout;       //超时时间
	private int dbnum;         //哪个库

	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public int getTimeout() {
        return timeout;
    }
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
    public int getDbnum() {
        return dbnum;
    }
    public void setDbnum(int dbnum) {
        this.dbnum = dbnum;
    }
    
    
}
