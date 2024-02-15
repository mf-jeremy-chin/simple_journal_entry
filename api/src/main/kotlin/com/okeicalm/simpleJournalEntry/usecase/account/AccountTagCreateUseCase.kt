package com.okeicalm.simpleJournalEntry.usecase.account

import com.okeicalm.simpleJournalEntry.entity.AccountTag
import com.okeicalm.simpleJournalEntry.repository.AccountTagRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

data class AccountTagCreateUseCaseInput(val name: String, val accountId: Long)
data class AccountTagCreateUseCaseOutput(val accountTag: AccountTag)

interface AccountTagCreateUseCase {
    fun call(input: AccountTagCreateUseCaseInput): AccountTagCreateUseCaseOutput
}

@Service
class AccountTagCreateUseCaseImpl(private val accountRepository: AccountTagRepository) : AccountTagCreateUseCase {
    @Transactional
    override fun call(input: AccountTagCreateUseCaseInput): AccountTagCreateUseCaseOutput {
        val account = AccountTag(
            name = input.name,
            account_id = input.accountId
        )
        return AccountTagCreateUseCaseOutput(accountRepository.create(account))
    }
}
