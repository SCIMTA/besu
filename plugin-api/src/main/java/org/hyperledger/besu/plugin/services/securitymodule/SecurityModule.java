/*
 * Copyright ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.hyperledger.besu.plugin.services.securitymodule;

import org.hyperledger.besu.plugin.Unstable;
import org.hyperledger.besu.plugin.services.securitymodule.data.PublicKey;
import org.hyperledger.besu.plugin.services.securitymodule.data.Signature;

import org.apache.tuweni.bytes.Bytes32;

/**
 * Provides a generic interface for classes which wrap/hide a cryptographic private key. This
 * interface ensures cryptographic functions required by Ethereum are available to the application
 * at large, without releasing the content of the private key.
 */
@Unstable
public interface SecurityModule {

  /**
   * Produces a signature for the given hash.
   *
   * @param dataHash The Keccack hash of a set of data, which is to be signed.
   * @return the signature (R, S) generated by signing the hash with the node key
   * @throws SecurityModuleException if sign fails
   */
  Signature sign(Bytes32 dataHash) throws SecurityModuleException;

  /**
   * The public key associated with this security module.
   *
   * @return the public key associated with the key stored behind this interface.
   * @throws SecurityModuleException if getPublicKey fails
   */
  PublicKey getPublicKey() throws SecurityModuleException;

  /**
   * Perform ECDH key agreement calculations.
   *
   * @param partyKey the key with which an agreement is to be created.
   * @return The bytes forming the agreement
   * @throws SecurityModuleException if calculateECDHKeyAgreement fails
   */
  Bytes32 calculateECDHKeyAgreement(PublicKey partyKey) throws SecurityModuleException;
}
