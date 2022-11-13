/*
 * Copyright 1998-2022 Linux.org.ru
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package ru.org.linux.spring;

import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.spring.template.SpringTemplateLoader;
import de.neuland.jade4j.template.JadeTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class JadeTemplatesConfiguration {
  @Bean
  public SpringTemplateLoader templateLoader() {
    SpringTemplateLoader templateLoader = new SpringTemplateLoader();
    templateLoader.setBasePath("template/");
    return templateLoader;
  }

  @Bean
  public JadeConfiguration jadeConfiguration(SpringTemplateLoader loader) {
    JadeConfiguration cfg = new JadeConfiguration();
    cfg.setPrettyPrint(false);
    cfg.setCaching(true);
    cfg.setTemplateLoader(loader);
    return cfg;
  }

  @Bean(name="TemplateComment")
  public JadeTemplate templateComment(JadeConfiguration cfg) throws IOException {
    return cfg.getTemplate("comment");
  }
}
