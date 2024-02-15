package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.AccountType
import com.okeicalm.simpleJournalEntry.usecase.account.AccountDeleteUseCase
import com.okeicalm.simpleJournalEntry.usecase.account.AccountDeleteUseCaseInput
import com.okeicalm.simpleJournalEntry.usecase.account.AccountTagDeleteUseCase
import com.okeicalm.simpleJournalEntry.usecase.account.AccountTagDeleteUseCaseInput
import org.springframework.stereotype.Component

data class DeleteAccountTagInput(val id: ID)

data class DeleteAccountTagPayload(val id: ID)

@Component
class DeleteAccountTagMutation(private val accountTagDeleteUseCase: AccountTagDeleteUseCase) : Mutation {
    fun deleteAccountTag(input: DeleteAccountTagInput): DeleteAccountTagPayload {
        accountTagDeleteUseCase.call(AccountTagDeleteUseCaseInput(id = input.id.toString().toLong()))

        return DeleteAccountTagPayload(input.id)
    }
}
