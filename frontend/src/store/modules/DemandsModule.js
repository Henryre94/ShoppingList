import axios from "axios";

export const DemandsModule = {
    state: {
        demands: [],
        pubId: 1
    },
        mutations: {
            increaseDemands(state, proId) {
                const product = state.demands.find(prod => prod.proId === proId)
                if (product) {
                    product.quantity++
                } else {
                    state.demands.push({
                        proId: proId,
                        pubId: 1,
                        quantity: 1
                    })
                }
            },
            decreaseDemands(state, proId) {
                const product = state.demands.find(prod => prod.proId === proId)
                if (product && product.quantity > 0) {
                    product.quantity--
                }
            },
            getVendorsDemand(state,demandList){
                state.demands = demandList
            },
            deleteVendorsDemand(state, proId) {
                const demandIndex = state.demands.findIndex(demand => demand.id === proId)
                state.demands.splice(demandIndex, 1)
            },

        },
        actions: {
            async increaseDemands(store, proId) {
                console.log(proId)
                await axios.post('/api/demands/' + proId + '/pubs/' + store.state.pubId)
                    .then(response => {
                        console.log(response.data);
                    })
                    .catch(error => {
                        console.log(error.response.status);
                    });
                store.commit('increaseDemands', proId)
            },
            async decreaseDemands(store, proId) {
                await axios.put('/api/demands/' + proId + '/pubs/' + store.state.pubId)
                    .then(response => {
                        console.log(response.data);
                    })
                    .catch(error => {
                        console.log(error.response.status);
                    });
                store.commit('decreaseDemands', proId)
            },
            async getVendorsDemand(store,venId) {
                const response = await axios.get("/api/demands/vendor/" + venId);
                console.log(response)
                store.commit("getVendorsDemand", response.data)
            },
            async editVendorsDemand(store, payload) {
                console.log(this.demands)
                await axios.put("/api/demands/" + payload.demands.proId + "/pubs/" + payload.demands.pubId)
                console.log(payload);
                await store.dispatch('getVendorsDemand', payload.pubId);

            },
            async delVendorsDemand(store, payload) {
                await axios.delete("/api/demands/" + payload.proId + "/pubs/" + payload.pubId)
                store.commit('deleteVendorsDemand', payload.pubId);
            },
        }
    }