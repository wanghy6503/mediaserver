/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, Telestax Inc and individual contributors
 * by the @authors tag. 
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

package org.mobicents.media.control.mgcp.pkg.base;

/**
 * @author Henrique Rosa (henrique.rosa@telestax.com)
 *
 */
public enum MgcpEventType {

    OPERATION_COMPLETE("oc"),
    OPERATION_FAILURE("of");

    private final String symbol;

    private MgcpEventType(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }

    public static final MgcpEventType fromSymbol(String symbol) {
        if (symbol != null && !symbol.isEmpty()) {
            for (MgcpEventType eventType : values()) {
                if (eventType.symbol.equalsIgnoreCase(symbol)) {
                    return eventType;
                }
            }
        }
        return null;
    }

}