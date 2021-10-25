import * as React from 'react'
import '../scss/chart.css'
// import ReactDOM from 'react-dom'
import ReactApexChart from 'react-apexcharts';
class ApexChart extends React.Component {

  constructor(props) {
    super(props);

    this.state = {
      
      series: [{
        name: "투표 수",
        data: [387,239,237,236,222,219,217,201,193,193,184,177,176,172,172,163,149,141,137,134]
      }],
      options: {
        chart: {
          type: 'line',
          height: 350,
          width: '10%'
        },
        plotOptions: {
          bar: {
            borderRadius: 4,
            horizontal: true,
            columnWidth:'5%',
            barHeight:'70%'
          }
        },
        dataLabels: {
          enabled: true,
          style:{
            fontSize:'14px',
            colors: ['#000']
          }
        },
        xaxis: {
          categories: ['콘푸로스트/초코첵스&우유','회오리감자','눈꽃가득생크림카스테라케이크','전주수제초코파이','치즈케이크','모듬떡볶이&김말이튀김','초코우유','스무디샤베트','쥬시쿨','수제블루베리요거트','비요뜨','야쿠르트','오징어먹물피자','골드키위','치킨커틀렛/브라운소스','마늘바게트&생크림','안동찜닭','우리밀오곡찐빵','비피더스','김치라면'
          ],
          labels:{
            show:false
          },
          axisBorder:{
            show:false
          }
        },
        yaxis:{
          labels:{
            mixWidth:30,
            maxWidth:1800,
            align:'right',
          },
          logarithmic:false
        },
        fill:{
          colors : [function({value,seriesIndex,w}){
            if(value<300){
              return '#F3D586'
            }else{
              return '#F3AB8C'
            }}]
        },
        crosshair:{
          width:2,
          position:'front'
        },
        grid:{
          show:false
        },
        legend:{
          show:false
        },
        stroke:{
          show:true
        }
      },
    
    
    };
  }
  render() {
    return (
      <div id="chart">
      <ReactApexChart options={this.state.options} series={this.state.series} type="bar" height={900} />
      </div>
    );
  }
}

export default ApexChart
// const domContainer = document.querySelector('#app');
// ReactDOM.render(React.createElement(ApexChart), domContainer);