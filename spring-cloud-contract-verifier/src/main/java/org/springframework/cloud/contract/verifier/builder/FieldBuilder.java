/*
 * Copyright 2013-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.contract.verifier.builder;

class FieldBuilder {

	private final ClassBodyBuilder parentBuilder;

	private final BlockBuilder builder;

	private final GeneratedClassMetaData metaData;

	FieldBuilder(ClassBodyBuilder parentBuilder) {
		this.parentBuilder = parentBuilder;
		this.builder = parentBuilder.blockBuilder;
		this.metaData = parentBuilder.generatedClassMetaData;
	}

	FieldBuilder messaging() {
		this.parentBuilder.field(new MessagingFields(this.builder, this.metaData));
		return this;
	}

	FieldBuilder customMode() {
		this.parentBuilder.field(new CustomModeFields(this.builder, this.metaData));
		return this;
	}

	ClassBodyBuilder build() {
		return this.parentBuilder;
	}

}
