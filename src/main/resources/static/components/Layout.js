import React from 'react';
import { Transition, TransitionGroup } from 'react-transition-group';

import './Layout.css';

export default ({ children, location }) => (
  <>
    <TransitionGroup component={null}>
      <Transition key={location.pathname} timeout={{ enter: 300, exit: 300 }}>
        {status => <div className={`page ${status}`}>{children}</div>}
      </Transition>
    </TransitionGroup>
  </>
);
