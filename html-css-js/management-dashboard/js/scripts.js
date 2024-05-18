// Slidebar Toggle

var slidebarOpen = false;
var Slidebar = document.getElementById("sidebar");

var openSidebar = () => {
    if(!slidebarOpen) {
        Slidebar.classList.add("slide-responsive");
        slidebarOpen = true;
    }
}

var closeSidebar = () => {
    if(slidebarOpen) {
        Slidebar.classList.remove("slide-responsive");
        slidebarOpen = false;
    }
}

// charts
// bar-chart
var barChartOptions = {
    series: [{
    data: [12, 8, 10, 6, 15]
  }],
    chart: {
    type: 'bar',
    height: 350,
    toolbar: {
        show: false
    }
  },
  color: [
    "#123456",
    "#234561",
    "#345612",
    "#456123",
    "#561234",
  ],
  plotOptions: {
    bar: {
      distributed: true,
      borderRadius: 4,
      horizontal: false,
      columnWidth: '40%',
    }
  },
  dataLabels: {
    enabled: false
  },
  legend: {
    show: false
  },
  xaxis: {
    categories: ["Laptop", "Phone", "Monitor", "Headphones", "Camera"
    ],
  },
  yaxis: {
    title: {
        text: "Count"
    }
  }
  };

  var barChart = new ApexCharts(document.querySelector("#bar-chart"), barChartOptions);
  barChart.render();

// area chart
var areaChartOptions = {
    series: [{
    name: 'Purchars Orders',
    // type: 'area',
    data: [69,50,45,44,55,77]
    }, {
    name: 'Sales Orders',
    // type: 'line',
    data: [1,5,2,10,6,25]
  }],
    chart: {
    height: 350,
    type: 'area',
    toolbar: {
      show: false
    }
  },
  color: ["#345252", "#456123"],
  stroke: {
    curve: 'smooth'
  },
  fill: {
    type:'solid',
    opacity: [0.35, 1],
  },
  labels: ['A','B','C','D','E','F'],
  markers: {
    size: 0
  },
  yaxis: [
    {
      title: {
        text: 'Purchars Orders',
      },
    },
    {
      opposite: true,
      title: {
        text: 'Sales Orders',
      },
    },
  ],
  tooltip: {
    shared: true,
    intersect: false,
    y: {
      formatter: function (y) {
        if(typeof y !== "undefined") {
          return  y.toFixed(0) + " points";
        }
        return y;
      }
    }
  }
  };

  var areaChart = new ApexCharts(document.querySelector("#area-chart"), areaChartOptions);
  areaChart.render();

  // circle chart-1
  var circleChartOptions_1 = {
    chart: {
        height: 300,
        type: 'radialBar',
    },
    colors: ["#abbe21"],
    series: [70],
    labels: ['Sales'],
  }
  
  var circleChart_1 = new ApexCharts(document.querySelector("#circle-chart-1"), circleChartOptions_1);
  circleChart_1.render();

    // circle chart-2
    var circleChartOptions_2 = {
      chart: {
          height: 300,
          type: 'radialBar',
      },
      colors: ["#114422"],
      series: [30],
      labels: ['Sales'],
    }
    
    var circleChart_2 = new ApexCharts(document.querySelector("#circle-chart-2"), circleChartOptions_2);
    circleChart_2.render();

      // circle chart-3
  var circleChartOptions_3 = {
    chart: {
        height: 300,
        type: 'radialBar',
    },
    colors: ["#35ff22"],
    series: [60],
    labels: ['Sales'],
  }
  
  var circleChart_3 = new ApexCharts(document.querySelector("#circle-chart-3"), circleChartOptions_3);
  circleChart_3.render();