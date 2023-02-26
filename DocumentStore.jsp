<!DOCTYPE html>
<html>

<head>
	<title>Document Store</title>
	<!-- Link to Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-HcJ78TuVuZ+JOU9bqzLeL3O5CRMvUXiDGA8FbRVGgTimeK59OIVJzIyIbbVYjBk7" crossorigin="anonymous">
	<style>
		body {
			padding: 50px;
		}
		form {
			margin-bottom: 20px;
		}
		table {
			margin-top: 50px;
		}
	</style>
</head>
<body>
	<div class="container">
		<h1>Document Store</h1>
			<form method="post" action="/filter" class="form-inline">
		<div class="form-group">
			<label for="filter">Filter:</label>
			<input type="text" name="filter" id="filter" class="form-control" />
		</div>
		<button type="submit" class="btn btn-primary ml-3">Filter</button>
	</form>
	
	<form method="post" action="/search" class="form-inline">
		<div class="form-group">
			<label for="query">Search:</label>
			<input type="text" name="query" id="query" class="form-control" />
		</div>
		<button type="submit" class="btn btn-primary ml-3">Search</button>
	</form>
	
	<form method="post" action="/recommend" class="form-inline">
		<div class="form-group">
			<label for="templateId">Template ID:</label>
			<input type="text" name="templateId" id="templateId" class="form-control" />
		</div>
		<button type="submit" class="btn btn-primary ml-3">Recommend</button>
	</form>
	
	<form method="post" action="/tag" class="form-inline">
		<div class="form-group">
			<label for="tag">Tag:</label>
			<input type="text" name="tag" id="tag" class="form-control" />
		</div>
		<button type="submit" class="btn btn-primary ml-3">Tag</button>
	</form>
	
	<form method="post" enctype="multipart/form-data" action="/store">
		<div class="form-group">
			<label for="file">Upload:</label>
			<input type="file" name="file" id="file" multiple class="form-control-file" />
		</div>
		<button type="submit" class="btn btn-primary ml-3">Upload</button>
	</form>
	
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>File Name</th>
				<th>Description</th>
				<th>Template ID</th>
				<th>Tags</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<!-- Iterate over documents and display them -->
			{{#each documents}}
			<tr>
				<td>{{this.id}}</td>
				<td>{{this.fileName}}</td>
				<td>{{this.description}}</td>
				<td>{{this.templateId}}</td>
				<td>{{this.tags}}</td>
				<td>
		  </tbody>
    </table>

    <!-- Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>

</html>
				
