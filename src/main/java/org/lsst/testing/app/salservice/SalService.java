/*
 * LSST Observatory Control System (OCS) Software
 * Copyright 2008-2017 AURA/LSST.
 *
 * This product includes software developed by the
 * LSST Project (http://www.lsst.org/) with contributions made at LSST partner
 * institutions.  The list of partner institutions is found at:
 * http://www.lsst.org/lsst/about/contributors .
 *
 * Use and redistribution of this software is covered by the GNU Public License
 * Version 3 (GPLv3) or later, as detailed below.  A copy of the GPLv3 is also
 * available at <http://www.gnu.org/licenses/>.
 */

package org.lsst.testing.app.salservice;

/**
 * <h2>SAL Service</h2>
 *
 * {@code SalService} is the Command Interface class in the command pattern
 */
public abstract class SalService {

    protected String _topic;
    protected Object[] _topicArgs;

    public void setTopic( String topic ) { _topic = topic; }

    public void setTopicArgs( Object[] topicArgs ) { _topicArgs = topicArgs; }

    public abstract void execute();
}
