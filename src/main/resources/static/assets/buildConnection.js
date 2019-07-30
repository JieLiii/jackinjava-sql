new Vue({
  el: '#app',
  created: function () {

  },
  data: function () {
    return {
      connectionUrl: 'http://localhost:8188/sql/connection/buildConnect',
      tablesUrl: 'http://localhost:8188/sql/connection/get-tables',
      columnsUrl: 'http://localhost:8188/sql/connection/get-columns',
      datasource: {
        databaseType: '',
        host: '192.168.211.131',
        port: '3306',
        database: 'mydemo',
        userName: 'lj',
        password: 'lijie'
      },
      databases : [],
      props: {
        label: 'name',
        children: 'tables'
      },
      visible: false
    }
  },
  methods: {
    onConnect: function () {
      var me = this;
      axios.post(me.connectionUrl, me.datasource).then(function (rs) {
        me.databases = rs.data;
        console.log(rs.data);
        me.$notify({
          message: '成功连接',
          type: 'success'
        });
      }).catch(function (reason) {
        me.$notify.error({
          message: '连接失败'
        });
      });
    },
    loadTables: function (node, resolve) {
      var me = this;
      if (node.level === 0) {
        return resolve(me.databases);
      } else if(node.level === 1) {
        axios.get(me.tablesUrl, {params: {databaseName: node.data.name}}).then(function (rs) {
          return resolve(rs.data);
        });
      } else {
        axios.get(me.columnsUrl, {params: {databaseName: node.parent.data.name, tableName: node.data.name}}).then(function (rs) {
          return resolve(rs.data);
        });
      }
    },
    handleNodeClick: function (data, node) {
      if(node.level === 2){
        alert("这是表")
      } else {
        return
      }
    }
  }
});