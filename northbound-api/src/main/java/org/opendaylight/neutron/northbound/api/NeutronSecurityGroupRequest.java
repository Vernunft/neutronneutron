/*
 * Copyright (c) 2014, 2015 Red Hat, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.neutron.northbound.api;

import org.opendaylight.neutron.spi.NeutronSecurityGroup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
@XmlAccessorType (XmlAccessType.NONE)

public class NeutronSecurityGroupRequest
    implements INeutronRequest<NeutronSecurityGroup> {
    /**
    * See OpenStack Network API v2.0 Reference for a
    * description of annotated attributes and operations
    */

    @XmlElement (name = "security_group")
    NeutronSecurityGroup singletonSecurityGroup;

    @XmlElement (name = "security_groups")
    List<NeutronSecurityGroup> bulkRequest;

    NeutronSecurityGroupRequest() {
    }

    NeutronSecurityGroupRequest(List<NeutronSecurityGroup> bulk) {
        bulkRequest = bulk;
        singletonSecurityGroup = null;
    }

    NeutronSecurityGroupRequest(NeutronSecurityGroup group) {
        singletonSecurityGroup = group;
    }

    @Override
    public List<NeutronSecurityGroup> getBulk() {
        return bulkRequest;
    }

    @Override
    public NeutronSecurityGroup getSingleton() {
        return singletonSecurityGroup;
    }

    @Override
    public boolean isSingleton() {
        return (singletonSecurityGroup != null);
    }
}
