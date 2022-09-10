<template>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">{{ ('Project 1 Game') }}</div>

                    <div class="card-body">
                        <div class="main-description">
                                hello
                        </div>
                        <div class="options">
                                hello
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</template>

<script>
    export default {
        props:['user', 'gamestate'],

        data() {
            return {
                users:[],
                currentOptions: [],
                displayMessage: []
                }
        },
        mounted(){
            Echo.join('game-channel')
                .listen('GameStateUpdate', (event) => {
                    this.messages.push(event.message);
                })
                .here(user => {
                    this.users = user;
                })
                .joining(user => {
                    this.users.push(user);
                })
                .leaving(user => {
                    this.users = this.users.filter(u => u.id != user.id);
                });
        },

        created() {
            this.fetchMessages();


        },

        methods: {
            // utilize the get method that was setup in routes web.php
            //USE AXIOS.GET TO GET THE SELECTIONS AFTER THE CHANGES HAVE BEEN MADE
            fetchMessages() {
                axios.get('messages').then(response => {
                    this.messages = response.data;
                })
            },
            //Pushes message in to array with user
            sendMessage(){
                this.messages.push({
                    user:this.user,
                    message: this.newMessage
                });
                //Accesses value stored in v-model newMessage

                //USE POST TO SEND THE SELECTION THE USER MADE IN THE GAME
                axios.post('messages', {message: this.newMessage});
                this.newMessage = '';
            }
        }
    }
</script>
