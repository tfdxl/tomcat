/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.catalina.mapper;

import org.apache.catalina.Context;
import org.apache.catalina.Host;
import org.apache.catalina.Wrapper;
import org.apache.tomcat.util.buf.MessageBytes;

import javax.servlet.http.MappingMatch;

/**
 * Mapping data.
 *
 * @author Remy Maucherat
 */
public class MappingData {

    //匹配的host
    public Host host = null;

    //最新的版本
    public Context context = null;

    //context里面斜杠的个数
    public int contextSlashCount = 0;

    //所有的结果:主要用于多版本部署的场景
    public Context[] contexts = null;

    //匹配的Wrapper
    public Wrapper wrapper = null;

    //对于JspServlet,他对应的匹配的pattern是否包含通配符
    public boolean jspWildCard = false;

    public final MessageBytes contextPath = MessageBytes.newInstance();
    public final MessageBytes requestPath = MessageBytes.newInstance();
    public final MessageBytes wrapperPath = MessageBytes.newInstance();
    public final MessageBytes pathInfo = MessageBytes.newInstance();

    public final MessageBytes redirectPath = MessageBytes.newInstance();

    // Fields used by ApplicationMapping to implement javax.servlet.http.Mapping
    public MappingMatch matchType = null;

    public void recycle() {
        host = null;
        context = null;
        contextSlashCount = 0;
        contexts = null;
        wrapper = null;
        jspWildCard = false;
        contextPath.recycle();
        requestPath.recycle();
        wrapperPath.recycle();
        pathInfo.recycle();
        redirectPath.recycle();
        matchType = null;
    }
}
