/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.eventjuggler.rest;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.eventjuggler.model.RSVP;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
@XmlRootElement
class EventDetails extends Event {

    private Address location;
    private Group organizerGroup;
    private List<Attendance> attendance;

    public EventDetails() {
    }

    public EventDetails(org.eventjuggler.model.Event event) {
        super(event);

        location = new Address(event.getLocation());
        organizerGroup = new Group(event.getOrganizerGroup());

        attendance = new LinkedList<Attendance>();
        for (RSVP r : event.getAttendance()) {
            attendance.add(new Attendance(r));
        }
    }

    public List<Attendance> getAttendance() {
        return attendance;
    }

    public Address getLocation() {
        return location;
    }

    public Group getOrganizerGroup() {
        return organizerGroup;
    }

}
