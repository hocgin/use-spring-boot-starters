# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
# http://mirrors.shu.edu.cn/apache/incubator/skywalking/6.0.0-GA/apache-skywalking-apm-incubating-6.0.0-GA.tar.gz

file:
	mkdir -p ../dist; \
	wget http://mirrors.shu.edu.cn/apache/incubator/skywalking/6.0.0-GA/apache-skywalking-apm-incubating-6.0.0-GA.tar.gz -O ../dist/apache-skywalking-apm-incubating.tar.gz ; \
	mkdir -p ../agent; \
	cd ../dist; \
	tar -xvf apache-skywalking-apm-incubating.tar.gz ; \
	cp -r apache-skywalking-apm-incubating/agent/* ../agent

oap:
	cd oap; \
	cp ../../dist/apache-skywalking-apm-incubating.tar.gz ./ ; \
	docker build -t skywalking/oap:latest .

ui:
	cd ui; \
	cp ../../dist/apache-skywalking-apm-incubating.tar.gz ./ ; \
	docker build -t skywalking/ui:latest .
	
build: file oap ui

.PHONY: file oap ui