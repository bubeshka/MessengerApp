package com.nchikvinidze.messengerapp.Search

import com.nchikvinidze.messengerapp.DependencyInjector
import com.nchikvinidze.messengerapp.data.User

class SearchPresenter(view: SearchList.View,
                    dependencyInjector: DependencyInjector
) : SearchList.Presenter {

    private val interactor = SearchInteractor(this)
    private var view: SearchList.View? = view

    override fun onViewCreated() {
        view?.showLoader()
        interactor.loadUsers(null)
    }

    override fun dataLoaded(data: List<User>) {
        view?.hideLoader()
        view?.showUsers(data)
    }

    override fun onDestroy() {
        this.view = null
    }

    override fun backClicked() {
        view?.showHome()
    }

    override fun search(name: String?) {
        view?.showLoader()
        interactor.loadUsers(name)
    }

    override fun userClicked(user: User) {
        view?.showChat(user)
    }
}