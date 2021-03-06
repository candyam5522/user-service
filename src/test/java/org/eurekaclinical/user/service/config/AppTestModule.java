/*-
 * #%L
 * Eureka! Clinical User Services
 * %%
 * Copyright (C) 2016 Emory University
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.eurekaclinical.user.service.config;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

import org.eurekaclinical.user.service.dao.AuthenticationMethodDao;
import org.eurekaclinical.user.service.dao.JpaRoleDao;
import org.eurekaclinical.user.service.dao.JpaUserDao;
import org.eurekaclinical.user.service.dao.JpaAuthenticationMethodDao;
import org.eurekaclinical.user.service.dao.JpaLocalUserDao;
import org.eurekaclinical.user.service.dao.JpaLoginTypeDao;
import org.eurekaclinical.user.service.dao.JpaOAuthProviderDao;
import org.eurekaclinical.user.service.dao.LocalUserDao;
import org.eurekaclinical.user.service.dao.LoginTypeDao;
import org.eurekaclinical.user.service.dao.OAuthProviderDao;
import org.eurekaclinical.user.service.dao.RoleDao;
import org.eurekaclinical.user.service.dao.UserDao;
import org.eurekaclinical.user.service.email.EmailSender;
import org.eurekaclinical.user.service.email.MockEmailSender;
import org.eurekaclinical.common.comm.clients.WebResourceWrapperFactory;
import org.eurekaclinical.common.comm.clients.cassupport.CasWebResourceWrapperFactory;

/**
 * Configure Guice for non-web application testing.
 *
 * @author miaoai
 *
 */
public class AppTestModule extends AbstractModule {

	@Override
	protected void configure() {

		install(new JpaPersistModule("eurekaclinical-user-service-jpa-unit"));

		bind(UserDao.class).to(JpaUserDao.class);
		bind(org.eurekaclinical.standardapis.dao.UserDao.class).to(JpaUserDao.class);
		bind(LocalUserDao.class).to(JpaLocalUserDao.class);
		bind(RoleDao.class).to(JpaRoleDao.class);
		bind(OAuthProviderDao.class).to(JpaOAuthProviderDao.class);
		bind(AuthenticationMethodDao.class).to(JpaAuthenticationMethodDao.class);
		bind(LoginTypeDao.class).to(JpaLoginTypeDao.class);
		bind(EmailSender.class).to(MockEmailSender.class);
		bind(WebResourceWrapperFactory.class).to(CasWebResourceWrapperFactory.class);
	}
}
