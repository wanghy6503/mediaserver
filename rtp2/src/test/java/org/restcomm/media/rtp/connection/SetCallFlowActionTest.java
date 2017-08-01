/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2017, Telestax Inc and individual contributors
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

package org.restcomm.media.rtp.connection;

import static org.mockito.Mockito.*;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Henrique Rosa (henrique.rosa@telestax.com)
 *
 */
public class SetCallFlowActionTest {

    @Test
    public void testInboundFlow() {
        // given
        final RtpConnectionContext globalContext = mock(RtpConnectionContext.class);
        final RtpConnectionFsm fsm = mock(RtpConnectionFsm.class);
        final RtpConnectionTransitionContext context = new RtpConnectionTransitionContext();

        when(fsm.getContext()).thenReturn(globalContext);

        // when
        final SetCallFlowAction action = new SetCallFlowAction();
        action.execute(RtpConnectionState.IDLE, RtpConnectionState.OPEN, RtpConnectionEvent.OPEN, context, fsm);

        // then
        verify(globalContext).setInbound(true);
        assertTrue(context.get(RtpConnectionTransitionParameter.INBOUND, Boolean.class));
    }

    @Test
    public void testOutboundFlow() {
        // given
        final RtpConnectionContext globalContext = mock(RtpConnectionContext.class);
        final RtpConnectionFsm fsm = mock(RtpConnectionFsm.class);
        final RtpConnectionTransitionContext context = new RtpConnectionTransitionContext();
        
        when(fsm.getContext()).thenReturn(globalContext);
        
        // when
        final SetCallFlowAction action = new SetCallFlowAction();
        action.execute(RtpConnectionState.IDLE, RtpConnectionState.OPEN, RtpConnectionEvent.HALF_OPEN, context, fsm);
        
        // then
        verify(globalContext).setInbound(false);
        assertFalse(context.get(RtpConnectionTransitionParameter.INBOUND, Boolean.class));
    }

}
