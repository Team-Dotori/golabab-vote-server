import * as React from 'react'
import one from '../images/medal_1.png'
import two from '../images/medal_2.png'
import three from '../images/medal_3.png'
import four from '../images/medal_4.png'
import five from '../images/medal_5.png'
import crown from '../images/crown2.png'
import '../scss/Card.css'

const card = () =>(
  <form className="flexable">
    <div className="cards">
      <div className="name">
        <p>전주수제초코파이</p>
      </div>
      <div className="num">
        <p>236표</p>
        <img src={four} className="img"/>
      </div>
    </div>
    <div className="cardss">
      <div className="name">
        <p>회오리감자</p>
      </div>
      <div className="num">
        <p>239표</p>
        <img src={two} className="img"/>
      </div>
    </div>
    <div className="fcard">
      <div className="name">
        <img src={crown} className="img"/>
        <p>콘푸로스트/초코첵스&우유</p>
      </div>
      <div className="num">
        <p>387표</p>
        <img src={one} className="img"/>
      </div>
    </div>
    <div className="cardss">
      <div className="name">
        <p>눈꽃가득생크림카스테라케이크</p>
      </div>
      <div className="num">
        <p>237표</p>
        <img src={three} className="img"/>
      </div>
    </div>
    <div className="cards">
      <div className="name">
        <p>치즈케이크</p>
      </div>
      <div className="num">
        <p>222표</p>
        <img src={five} className="img"/>
      </div>
    </div>
    {/* <p id="four">육개장</p>
    <img src={four} className="cards"></img> */}
    {/* <p id="fours">78표</p> */}
    {/* <p id="two">참치김치볶음밥</p> */}
    {/* <img src={two} className="cardss"></img> */}
    {/* <p id="twos">90표</p> */}
    <>
      {/* <img src={crown} id="crown"/> */}
      {/* <p id="one">초코우유</p> */}
      {/* <img src={one} className="fcard"></img> */}
    {/* <p id="ones">110표</p> */}
    </>
    {/* <p id="three">갈비 만두</p> */}
    {/* <img src={three} className="cardss"></img> */}
    {/* <p id="threes">89표</p>
    <p id="five">닭정육통살구이</p> */}
    {/* <img src={five} className="cards"></img> */}
    {/* <p id="fives">70표</p> */}
  </form>
)

export default card