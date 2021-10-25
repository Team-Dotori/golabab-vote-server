import * as React from 'react'
import '../scss/result.css'
import Header from '../images/header.png'
import Chart from '../components/Chart'
import Card from '../components/Card'


const result = () =>(
  <>
    <form className="resultIndex">
      <div id="bg">
        <img src={Header} id="HeaderImg"/>
          <p id="subtitle">2주의 급식</p>
        <div className="cardArea">
          <div className="Card">
            <Card/>
          </div>
        </div>
      </div>
      <div className="ChartArea">
        <div className="Chart">
          <div className="cw">
            <Chart/>
          </div>
        </div>
      </div>
      <footer>
        <p>ⓒ 2021. Team Dotori</p>
      </footer>
    </form>
  </>
)

export default result