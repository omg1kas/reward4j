/**
 * Copyright 2009-2010 reward4j.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.reward4j.dao.jpa;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.reward4j.dao.RateableActionDao;
import org.reward4j.dao.RateableActionNotExistException;
import org.reward4j.model.RateableAction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class RateableActionJpaDaoTest {

  @Resource
  private RateableActionDao rateableActionDao;

  @Transactional
  @Test
  public void saveAndReadAction() throws RateableActionNotExistException {
    RateableAction action = new RateableAction("testAction");
    this.rateableActionDao.saveAction(action);

    RateableAction savedAction = this.rateableActionDao.getAction("testAction");
    assertThat(savedAction, equalTo(action));
  }

  @Test(expected = RateableActionNotExistException.class)
  public void tryToReadNotExistingAction() throws RateableActionNotExistException {
    this.rateableActionDao.getAction("notExistingAction");
  }

}
