import * as React from 'react'
import Link from 'gatsby-link'
import 'animate.css'
import '../scss/style.css'
import Logo from '../images/golabob_logo2.png'


const App = () =>(
  <div className="map">
    <form>
      <img src={Logo} className="logo"/>
      <div className="btn"><Link to="/result"> <div className="select">결과 확인하기</div></Link></div>
    </form>
  </div>
)

export default App