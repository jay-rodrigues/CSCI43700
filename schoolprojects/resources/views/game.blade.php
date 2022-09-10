@extends('layouts.app')

@section('content')
<div class="container">
    <gamescreen :user="{{ auth()->user() }}"></gamescreen>
</div>
@endsection
