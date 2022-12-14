package com.geekbrains.tests.repository

import com.geekbrains.tests.model.SearchResponse
import retrofit2.Response

internal class FakeGitHubRepository : RepositoryContract {
    override fun searchGithub(
        query: String,
        callback: GitHubRepositoryCallback
    ) {
        callback.handleGitHubResponse(Response.success(SearchResponse(42, listOf())))
    }
}
